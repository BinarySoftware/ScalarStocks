import scala.io.Source
import ScalarStocks._
import java.io.{PrintWriter,File}
import Debugger._

object DataManager {
    def getDataFromURLWithSymbols(urlString: String, symbols: Array[String]) : String = {
        val stringOfSymbols = symbols.mkString(",")
        val concatenatedURL = urlString.concat(stringOfSymbols)

        try {
            Source.fromURL(concatenatedURL).mkString
        }
        catch {
            case _ : Throwable => "An error has occurred"
        }
    }

    def saveDataToLocalFile() : Unit= {
        val writer = new PrintWriter(new File("symbols.txt"))
        val dataToWrite = symbols.mkString("\n")
        writer.write(dataToWrite)
        writer.close()
    }

    def loadDataFromLocalFile() : Unit = {
        val NO_DATA_INFORMATION = "\nFirst, you need to append symbols. Do that by clicking [A] and typing in symbol name"
        if (scala.reflect.io.File("symbols.txt").exists) {
            for (line <- Source.fromFile("symbols.txt").getLines()) {
                symbols :+= line
            }
        } else {
            viewer(NO_DATA_INFORMATION, Info())
        }
    }
}