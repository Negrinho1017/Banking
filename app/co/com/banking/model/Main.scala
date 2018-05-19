
package co.com.uco.banking.model

import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
object Main {

  case class Client(id: Int, username: String)
  // this is a class that represents the table I've created in the database
  class Clients(tag: Tag) extends Table[Client](tag, "clients") {
    def id = column[Int]("id")
    def username = column[String]("username")
    def * = (id, username) <> (Client.tupled, Client.unapply)
  }

  def main(args: Array[String]): Unit = {

    // my database server is located on the localhost
    // database name is "my-db"
    // username is "postgres"
    // and password is "postgres"
    val connectionUrl = "jdbc:postgresql://localhost/banking?user=postgres&password=tech"

    def Clients = TableQuery[Clients]
    val db = Database.forURL(connectionUrl, driver = "org.postgresql.Driver")

    val setup = DBIO.seq(
      Clients.schema.create,
      Clients += Client(3,"hola")
    )
    def create = Future {
      db.run(setup)
    }
    create
    def query = Future {
      db.run(Clients.result).map(_.foreach{
        case e => println(s"clients => ${e.id}")
      })
    }
    query
  }
}
