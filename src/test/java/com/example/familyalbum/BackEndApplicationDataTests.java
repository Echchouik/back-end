package com.example.familyalbum;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.familyalbum.model.Comment;
import com.familyalbum.model.Photo;
import com.familyalbum.model.User;
import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.dataset.DataSetExecutorImpl;
import com.github.database.rider.core.util.EntityManagerProvider;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class BackEndApplicationDataTests {

	@Rule
	public EntityManagerProvider emProvider = EntityManagerProvider.instance("riderDB");

	@Rule
	public DBUnitRule dbUnitRule = DBUnitRule.instance(emProvider.connection());

	@Test
	@DataSet(value = "datasets/users.yml", cleanBefore = true)
	public void shouldListUsers() {
		List<User> users = EntityManagerProvider.em().createQuery("select u from User u").getResultList();
		assertThat(users).isNotNull().isNotEmpty().hasSize(2);
	}
	
	@Test
	@DataSet(value = "datasets/photos.yml", cleanBefore = true)
	public void shouldListPhotos() {
		List<Photo> photos = (List<Photo>) EntityManagerProvider.em().createQuery("select p from photo p").getResultList();
		assertThat(photos).isNotNull().isNotEmpty().hasSize(2);
	}
	
	@Test
	@DataSet(value = "datasets/comments.yml", cleanBefore = true)
	public void shouldListComments() {
		List<Comment> comments = EntityManagerProvider.em().createQuery("select c from comment c").getResultList();
		assertThat(comments).isNotNull().isNotEmpty().hasSize(1);
	}
	
	@AfterClass
    public static void close() throws SQLException {
        DataSetExecutorImpl.getExecutorById(DataSetExecutorImpl.DEFAULT_EXECUTOR_ID).getConnection().close();
    }
}
