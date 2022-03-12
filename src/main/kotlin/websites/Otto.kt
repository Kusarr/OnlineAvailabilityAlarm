package websites

import WebdriverUtil
import Website
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import java.math.BigDecimal

class Otto(override val driver: ChromeDriver) : Website {

    override val urls =
        listOf(
            "https://www.otto.de/technik/gaming/playstation/ps5/"
        )

    override fun checkAvailability() {
        val products = driver.findElements(By.className("promo_articlelist--article"))
        products.forEach {
            val price = WebdriverUtil.parsePrice(it)
            if (price > BigDecimal.valueOf(300)) {
                handleSuccess("Playstation")
            }
        }
    }

}
