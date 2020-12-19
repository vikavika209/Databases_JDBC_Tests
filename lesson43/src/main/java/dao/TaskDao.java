package dao;

import entity.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class TaskDao {
  private final DataSource dataSource;

  public TaskDao(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Task save(Task task) {
    String sql = "INSERT INTO task (title, finished, created_date) VALUES(?, ?, ?)";
    try(Connection connection = dataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      statement.setString(1, task.getTitle());
      statement.setBoolean(2, task.getFinished());
      statement.setTimestamp(3, java.sql.Timestamp.valueOf(task.getCreatedDate()));
      statement.executeUpdate();
      try(ResultSet resultSet = statement.getGeneratedKeys()) {
        if (resultSet.next()) {
          task.setId(resultSet.getInt(1));
        }
      }
    } catch (SQLException throwables) {
      throw new RuntimeException(throwables);
    }
    return task;
  }
}
