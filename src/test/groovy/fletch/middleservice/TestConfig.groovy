package fletch.middleservice

import org.springframework.boot.test.context.TestConfiguration
import spock.mock.DetachedMockFactory

@TestConfiguration
class TestConfig {
    final factory = new DetachedMockFactory()

//    @Bean
//    MessageRepository messageRepository() {factory.createMock(MessageRepository)}
}
