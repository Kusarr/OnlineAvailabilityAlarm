package websites

import Website
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class Expert(override val driver: ChromeDriver) : Website {

    override val urls =
        listOf(
            "https://ps5.expert.de/Themenwelten/Sony-PS5.html"
        )

    override fun checkAvailability() {
        val ele = driver.findElements(By.cssSelector(".pageWrapper"))
        if (ele.isNotEmpty() && !ele[0].text.contains("Leider sind alle PS5™-Konsolen bereits vergriffen!")) {
            handleSuccess("Playstation")
        }
    }

}
