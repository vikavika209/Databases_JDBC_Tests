package dao;

import entity.Task;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import javax.sql.DataSource;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.postgresql.ds.PGSimpleDataSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskDaoTest {
  private TaskDao taskDao;

  @BeforeAll
  public void setUp() {
    PGSimpleDataSource dataSource = new PGSimpleDataSource();
    dataSource.setUser("user");
    dataSource.setPassword("password");
    dataSource.setDatabaseName("productStar");

    taskDao = new TaskDao(dataSource);
    initializeDb(dataSource);
  }

  private void initializeDb(DataSource dataSource) {
    try(InputStream inputStream = this.getClass().getResource("/initial.sql").openStream()) {
      String initializeSql = new String(inputStream.readAllBytes());
      try(Connection connection= dataSource.getConnection(); Statement statement = connection.createStatement()) {
        statement.execute(initializeSql);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void testSaveSetsId() {
    Task task = new Task("test task", false, LocalDateTime.now());
    taskDao.save(task);

    assertThat(task.getId()).isNotNull();
  }

  @Test
  public void testFindAllReturnsAllTasks() {

  }

  @Test
  public void testGetByIdReturnsCorrectTask() {

  }

  @Test
  public void testFindNotFinishedReturnsCorrectTasks() {

  }

  @Test
  public void testFindNewestTasksReturnsCorrectTasks() {

  }

  @Test
  public void testFinishSetsCorrectFlagInDb() {

  }

  @Test
  public void deleteAllDeletesAllData() {

  }

  @Test
  public void deleteByIdDeletesOnlyNecessaryData() {

  }
}
