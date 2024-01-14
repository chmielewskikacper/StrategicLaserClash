package service;

import entity.Gamer;
import entity.HitResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service("xmlDataService")
@RequiredArgsConstructor
@SessionScope

public class XMLDataService {

    public static List<Gamer> parseXml(String path) {
        List<Gamer> gamers = new ArrayList<>();
        List<HitResult> hitResultsList = new ArrayList<>();
        Gamer gamer = null;
        HitResult hit = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(path));
            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName()
                            .getLocalPart()) {
                        case "Gamer":
                            gamer = new Gamer();
                            Attribute name = startElement.getAttributeByName(new QName("Name"));
                            if (name != null) {
                                gamer.setName(name.getValue());
                            }
                            Attribute gamerID = startElement.getAttributeByName(new QName("GamerID"));
                            if (gamerID != null) {
                                gamer.setGamerID(Integer.parseInt(gamerID.getValue()));
                            }
                            Attribute teamColor = startElement.getAttributeByName(new QName("TeamColor"));
                            if (teamColor != null) {
                                gamer.setTeamColor(Integer.parseInt(teamColor.getValue()));
                            }
                            Attribute tagerType = startElement.getAttributeByName(new QName("TagerType"));
                            if (tagerType != null) {
                                gamer.setTagerType(Integer.parseInt(tagerType.getValue()));
                            }
                            Attribute tagerTypeName = startElement.getAttributeByName(new QName("TagerTypeName"));
                            if (tagerTypeName != null) {
                                gamer.setTagerTypeName(tagerTypeName.getValue());
                            }
                            Attribute fireCount = startElement.getAttributeByName(new QName("FireCount"));
                            if (fireCount != null) {
                                gamer.setFireCount(Integer.parseInt(fireCount.getValue()));
                            }
                            Attribute killed = startElement.getAttributeByName(new QName("Killed"));
                            if (killed != null) {
                                gamer.setKilled(Integer.parseInt(killed.getValue()));
                            }
                            Attribute medicine = startElement.getAttributeByName(new QName("Medicine"));
                            if (medicine != null) {
                                gamer.setMedicine(Integer.parseInt(medicine.getValue()));
                            }
                            Attribute damage = startElement.getAttributeByName(new QName("Damage"));
                            if (damage != null) {
                                gamer.setDamage(Integer.parseInt(damage.getValue()));
                            }
                            Attribute gameTime = startElement.getAttributeByName(new QName("GameTime"));
                            if (gameTime != null) {
                                gamer.setGameTime(LocalTime.parse(gameTime.getValue()));
                            }
                            break;
                        case "Hit":
                            if (gamer != null) {
                                hit = new HitResult();
                                StartElement hitStartElement = nextEvent.asStartElement();
                                Attribute gamerId = hitStartElement.getAttributeByName(new QName("GamerID"));
                                Attribute hits = hitStartElement.getAttributeByName(new QName("Hits"));
                                if (hits != null && Integer.parseInt(hits.getValue()) != 0 && gamerId != null) {
                                    hit.setHits(Integer.parseInt(hits.getValue()));
                                    hit.setGamerId(Integer.parseInt(gamerId.getValue()));
                                    hitResultsList.add(hit);
                                }
                            }
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName()
                            .getLocalPart()
                            .equals("Gamer")) {
                        if (gamer != null) {
                            gamer.setHitResults(hitResultsList);
                            gamers.add(gamer);
                            hitResultsList = new ArrayList<>();
                        }
                    }
                }
            }
        } catch (XMLStreamException xse) {
            System.out.println("XMLStreamException");
            xse.printStackTrace();
        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException");
            fnfe.printStackTrace();
        }
        return gamers;
    }
}


