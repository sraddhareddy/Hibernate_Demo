package com.stackroute.muzixapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixapp.model.Track;

@Repository
@Transactional
public class TrackDAOImpl implements TrackDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public TrackDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	//implement all the methods
	@Override
	public boolean saveTrack(Track track) {
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.saveOrUpdate(track);
		//session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteTrack(int id) {
		Session session=sessionFactory.getCurrentSession();
		//  session.beginTransaction();
		session.delete(getTrackById(id));
		// session.getTransaction().commit();
		return true;
	}

	@Override
	public List<Track> getAllTracks() {
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		List<Track>tracks=session.createQuery("from Track",Track.class).getResultList();
		//session.getTransaction().commit();
		return tracks;
	}

	@Override
	public Track getTrackById(int id) {
		Session session=sessionFactory.getCurrentSession();
		//   session.beginTransaction();
		Track track=session.get(Track.class,id);
		// session.getTransaction().commit();
		return track;
	}

	@Override
	public boolean UpdateTrack(Track track) {
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.update(track);
		//session.getTransaction().commit();
		return false;
	}

}