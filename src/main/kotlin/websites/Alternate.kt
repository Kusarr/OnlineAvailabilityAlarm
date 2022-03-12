package websites

import WebdriverUtil
import Website
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import java.math.BigDecimal

class Alternate(override val driver: ChromeDriver) : Website {

    override val urls =
        listOf(
            "https://www.alternate.de/Gaming/PlayStation?s=price_desc"
        )

    override fun checkAvailability() {
        val products = driver.findElements(By.className("price"))
        val price = WebdriverUtil.parsePrice(products[0])
        if (price > BigDecimal.valueOf(300)) {
            handleSuccess("Playstation")
        }
    }

}
