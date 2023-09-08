package dev.axgr

import org.springframework.ai.client.AiClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class App

@RestController
class WebsiteController(private val ai: AiClient) {

  @GetMapping("/websites/{topic}", produces = [MediaType.TEXT_HTML_VALUE])
  fun generate(@PathVariable topic: String): String {
    return ai.generate(
      """
      Return valid HTML5 for a $topic single-page website.
      Make the page look visually appealing by using different colors and fonts.
      Also, provide valid copy for the individual sections.
      """
    )
  }
}

fun main(args: Array<String>) {
  runApplication<App>(*args)
}
