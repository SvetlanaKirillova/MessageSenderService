## Messages Sender Service(Kafka Consumer)
Service saves to database, and send email to the specified address while Receiving new message from the kafka

## Server Parameters
- **host:** `localhost`
- **Port:** `8081`

## Configure Kafka Server

- **spring.kafka.bootstrap-servers:** `specify here kafka server host/port`
- **kafka.topic:** `kafka topic name`

## Configure PosgreSQL parameters in application.properties:

- **your.db**  – postreSQL DataBase
- **db.user** – postgreSQL username
- **db.user.password** – posgreSQL user's password

## Configure parameters for sending email:

- **mail.receiver.address**  – receiver email address
- **spring.mail.host** – mail host for sender(ex. smtp.yandex.kz)
- **spring.mail.port** – mail port for sender
- **spring.mail.username** - sender email address
- **spring.mail.password** - sender email password


## Methods 

### Get All Sent Emails

- **HTTP Method:** GET
- **Endpoint:** `/api/emails/`
- **Description:** Retrieve a list of all sent emails.
- **Response:** Returns a list of sent emails in the response body as an `EmailListDto`.

