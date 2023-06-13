package com.ges.officeservice.kafka;

import com.base.basemodel.dto.SocieteDTOKafka;
import com.ges.officeservice.entities.Societe;
import com.ges.officeservice.repository.CompteUtilisateurRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SocieteProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocieteProducer.class);
    private NewTopic topic;
    private KafkaTemplate<String, SocieteDTOKafka> kafkaTemplate;
    private CompteUtilisateurRepository compteUtilisateurRepository;

    public SocieteProducer(NewTopic topic, KafkaTemplate<String, SocieteDTOKafka> kafkaTemplate, CompteUtilisateurRepository compteUtilisateurRepository) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
        this.compteUtilisateurRepository = compteUtilisateurRepository;
    }
    public void sendMessage(Societe societe){
        LOGGER.info(String.format("Societe => %s",societe.getCompteUtilisateur().getId()));
        SocieteDTOKafka societeDTOKafka= SocieteDTOKafka.builder()
                .id(societe.getId())
                .activite(societe.getActivite())
                .compteUtilisateurId(societe.getCompteUtilisateur().getId())
                .adresse(societe.getAdresse())
                .raison_social(societe.getRaison_social())
                .build();
        Message<SocieteDTOKafka> message= MessageBuilder
                .withPayload(societeDTOKafka)
                .setHeader(KafkaHeaders.TOPIC,topic.name())
                .build();
        kafkaTemplate.send(message);
    }

    public void sendMessageDeletedSociete(Societe societe){
        LOGGER.info(String.format("Societe supprimer => %s",societe.getCompteUtilisateur().getId()));
        SocieteDTOKafka societeDTOKafka= SocieteDTOKafka.builder()
                .id(societe.getId())
                .activite(societe.getActivite())
                .compteUtilisateurId(societe.getCompteUtilisateur().getId())
                .adresse(societe.getAdresse())
                .raison_social(societe.getRaison_social())
                .build();
        Message<SocieteDTOKafka> message= MessageBuilder
                .withPayload(societeDTOKafka)
                .setHeader(KafkaHeaders.TOPIC, "deleted_societe")
                .build();
        kafkaTemplate.send(message);
    }

}
