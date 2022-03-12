package websites

import Website
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class MediaMarkt(override val driver: ChromeDriver) : Website {

    override val urls =
        listOf(
            "https://www.mediamarkt.de/de/product/_sony-playstation%C2%AE5-2661938.html",
            "https://www.saturn.de/de/product/_sony-playstation%C2%AE5-2661938.html?utm_source=easymarketing&utm_medium=aff-content&utm_term=52560&utm_campaign=Deeplinkgenerator-AO&emid=6229ead46166b414c11ba248"
        )

    override fun checkAvailability() {
        val cartButtons = driver.findElements(By.id("pdp-add-to-cart-button"))
        if (cartButtons.isNotEmpty()) {
            handleSuccess("Playstation")
        }
    }

}
