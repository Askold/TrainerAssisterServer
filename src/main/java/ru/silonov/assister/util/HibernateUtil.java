package ru.silonov.assister.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.silonov.assister.Constants;
import ru.silonov.assister.model.entity.*;

import java.io.File;

public class HibernateUtil {
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    public static SessionFactory getSessionFactory() {
        logger.info("start getSessionFactory()");
        File file = new File(Constants.DEFAULT_HBN_CONFIG_PATH);
        logger.debug("file name: " + file.getName());
        Configuration configuration = new Configuration().configure(file);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        metadataSources.addAnnotatedClass(Trainer.class);
        metadataSources.addAnnotatedClass(Client.class);
        metadataSources.addAnnotatedClass(Program.class);
        metadataSources.addAnnotatedClass(Workout.class);
        metadataSources.addAnnotatedClass(Exercise.class);
        metadataSources.addAnnotatedClass(SingleExercise.class);
        metadataSources.addAnnotatedClass(Feedback.class);

        SessionFactory sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        logger.info("end getSessionFactory()");
        return sessionFactory;
    }
}
