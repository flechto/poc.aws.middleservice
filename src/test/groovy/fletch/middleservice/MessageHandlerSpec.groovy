package fletch.middleservice

import spock.lang.Specification

//@SpringBootTest(classes = [TestConfig])
class MessageHandlerSpec extends Specification {

    MessageRepository messageRepository = Mock()
    MessageEvents messageEvents = Mock()
    MessageHandler messageHandler = new MessageHandler(
            messageRepository,
            messageEvents)

    def "creating thing"() {

        given: "A message to create a thing"
        final message = new Message("title", "text")

        when: "Message is recieved"
        messageHandler.handle(message)

        then: "It saves it to the repo"
        1 * messageRepository.save {it.title == message.title && it.text == message.text} >>> message

        and: "Emits a created event"
        1* messageEvents.emit(message)
    }
}
