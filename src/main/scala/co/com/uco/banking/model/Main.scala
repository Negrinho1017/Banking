
package co.com.uco.banking.model

import scala.slick.driver.PostgresDriver.simple._

object Main {

  // this is a class that represents the table I've created in the database
  class Client(tag: Tag) extends Table[(Int, String)](tag, "clients") {
    def id = column[Int]("id")
    def username = column[String]("username")
    def * = (id, username)
  }

  def main(args: Array[String]): Unit = {

    // my database server is located on the localhost
    // database name is "my-db"
    // username is "postgres"
    // and password is "postgres"
    val connectionUrl = "jdbc:postgresql://localhost/banking?user=postgres&password=tech"

    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val clients = TableQuery[Client]

        // SELECT * FROM clients
        clients.list foreach { row =>
          println("user with id " + row._1 + " has username " + row._2)
        }

        // SELECT * FROM clients WHERE username='john'
        clients.filter(_.username === "john").list foreach { row =>
          println("user whose name is 'john' has id " + row._1)
        }

    }
  }
}
