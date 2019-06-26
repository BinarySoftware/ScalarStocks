import scala.io.Source
import ScalarStocks._
import java.io.{PrintWriter,File}
import Message._
import PublicDef._

object DataManager {
    def getDataFromURLWithSymbols(urlString: String, symbols: Array[String]) : String = {
        val stringOfSymbols = symbols.mkString(",")
        val concatenatedURL = urlString.concat(stringOfSymbols)

        try {
            Source.fromURL(concatenatedURL).mkString
        }
        catch {
            case _ : Throwable => ERROR_BASE_MSG
        }
    }

    def saveDataToLocalFile() : Unit= {
        val writer = new PrintWriter(new File(dataFileName))
        val dataToWrite = symbols.mkString("\n")
        writer.write(dataToWrite)
        writer.close()
    }

    def loadDataFromLocalFile() : Unit = {
        if (scala.reflect.io.File(dataFileName).exists) {
            for (line <- Source.fromFile(dataFileName).getLines()) {
                symbols :+= line
            }
        } else {
            viewMessage(NO_DATA_INFORMATION, Info(),2)
        }
    }
}