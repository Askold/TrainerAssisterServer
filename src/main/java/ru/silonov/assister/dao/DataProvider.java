package ru.silonov.assister.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.silonov.assister.Constants;
import ru.silonov.assister.model.entity.*;
import ru.silonov.assister.util.HibernateUtil;

import java.nio.file.Watchable;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataProvider implements IDataProvider {

    private static final Logger logger = LogManager.getLogger(DataProvider.class);

    @Override
    public <T> boolean insert(T object) {

        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            logger.info(Constants.ADDED);
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public <T> Optional<T> getById(Class<T> tClass, int id) {
        Transaction transaction = null;
        Optional<T> optional;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            optional = Optional.ofNullable(session.get(tClass, id));
            transaction.commit();
            logger.info(Constants.FOUND);
            return optional;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    public List<Exercise> selectAllExercises() {
        Transaction transaction = null;
        List<Exercise> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("from Exercise", Exercise.class).list();
            logger.info(Constants.FOUND);
            return list;
        } catch (Exception e) {
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
    }

    public  Optional<Trainer> getTrainerByLogin(String login) {
        Transaction transaction = null;
        Optional<Trainer> optional;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query<Trainer> query = session.createQuery("from Trainer where login=:login");
            query.setParameter("login", login);
            optional = query.uniqueResultOptional();
            transaction.commit();
            logger.info(Constants.FOUND);
            return optional;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    public  Optional<Client> getClientByLogin(String login) {
        Transaction transaction = null;
        Optional<Client> optional;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query<Client> query = session.createQuery("from Client where login=:login");
            query.setParameter("login", login);
            optional = query.uniqueResultOptional();
            transaction.commit();
            logger.info(Constants.FOUND);
            return optional;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    public List<Client> getClientsByTrainer(int id){
        Transaction transaction = null;
        List<Client> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query<Client> query = session.createQuery("from Client where trainer=:trainer");
            query.setParameter("trainer", id);
            list = query.list();
            transaction.commit();
            logger.info(Constants.RECORDS_SELECTED);
            return list;
        }
        catch (Exception e){
            logger.error(e.getClass()+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return list;
        }
    }

    public List<Workout> getWorkoutsByProgramId(int id){
        Transaction transaction = null;
        List<Workout> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query<Workout> query = session.createQuery("from Workout where program=:program");
            query.setParameter("program", id);
            list = query.list();
            transaction.commit();
            logger.info(Constants.RECORDS_SELECTED);
            return list;
        }
        catch (Exception e){
            logger.error(e.getClass()+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return list;
        }
    }

    public List<SingleExercise> getExercisesByWorkout(int id){
        Transaction transaction = null;
        List<SingleExercise> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query<SingleExercise> query = session.createQuery("from SingleExercise where workoutId =:workout");
            query.setParameter("workout", id);
            list = query.list();
            transaction.commit();
            logger.info(Constants.RECORDS_SELECTED);
            return list;
        }
        catch (Exception e){
            logger.error(e.getClass()+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return list;
        }
    }

    public List<Program> getProgramByClient(int id){
        Transaction transaction = null;
        List<Program> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query<Program> query = session.createQuery("from Workout where client =:client");
            query.setParameter("client", id);
            list = query.list();
            transaction.commit();
            logger.info(Constants.RECORDS_SELECTED);
            return list;
        }
        catch (Exception e){
            logger.error(e.getClass()+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return list;
        }
    }

    public Exercise getExerciseByName(String name){
        Transaction transaction = null;
        Exercise exercise = new Exercise();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query<Exercise> query = session.createQuery("from Exercise where name =:name");
            query.setParameter("name", name);
            exercise = query.list().get(0);
            transaction.commit();
            logger.info(Constants.RECORDS_SELECTED);
            return exercise;
        }
        catch (Exception e){
            logger.error(e.getClass()+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return exercise;
        }
    }


    @Override
    public <T> boolean update(T object) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            logger.info(Constants.UPDATED);
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public <T> boolean delete(T object) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            logger.info(Constants.DELETED);
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }




    /**
     * Receives Session object via SessionFactory
     * @return Session object
     */
    Session getSession(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}
