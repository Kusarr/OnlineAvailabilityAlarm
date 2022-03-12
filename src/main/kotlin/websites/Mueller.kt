package websites

import WebdriverUtil
import Website
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import java.math.BigDecimal

class Mueller(override val driver: ChromeDriver) : Website {

    override val urls =
        listOf(
            "https://www.mueller.de/multi-media/konsolen-zubehoer/spielekonsolen/?filter.dm_system=PlayStation+5&sortBy=pricedesc"
        )

    override fun checkAvailability() {
        val products = driver.findElements(By.cssSelector(".mu-product-list .mu-product-tile__price"))
        val price = WebdriverUtil.parsePrice(products[0])
        if (price > BigDecimal.valueOf(300)) {
            handleSuccess("Playstation")
        }
    }

}
