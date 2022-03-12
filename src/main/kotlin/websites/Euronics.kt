package websites

import Website
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class Euronics(override val driver: ChromeDriver) : Website {

    override val urls =
        listOf(
            "https://www.euronics.de/spiele-und-konsolen-film-und-musik/spiele-und-konsolen/playstation-5/spielekonsole/playstation-5-mit-laufwerk-konsole-4065327217124",
            "https://www.euronics.de/spiele-und-konsolen-film-und-musik/spiele-und-konsolen/playstation-5/spielekonsole/playstation-5-dig.ed.-o.-laufwerk-konsole-4065327217117",
            "https://www.euronics.de/spiele-und-konsolen-film-und-musik/spiele-und-konsolen/playstation-5/spielekonsole/playstation-5-mit-laufwerk-bundle-inkl.-2.-controller-in-schwarz-weiss-4065327293999",
            "https://www.euronics.de/spiele-und-konsolen-film-und-musik/spiele-und-konsolen/playstation-5/spielekonsole/playstation-5-mit-laufwerk-bundle-konsole-inkl.-spiderman-miles-morales-4065327116823",
            "https://www.euronics.de/spiele-und-konsolen-film-und-musik/spiele-und-konsolen/playstation-5/spielekonsole/playstation-5-mit-laufwerk-bundle-konsole-inkl.-ratched-und-clank-rift-apart-4065327148145"
        )

    override fun checkAvailability() {
        val cartButtons = driver.findElements(By.id("buybox--button"))
        if (cartButtons.isNotEmpty()) {
            handleSuccess("Playstation")
        }
    }

}
