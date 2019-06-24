import io.circe.parser
import io.circe.generic.semiauto.deriveDecoder

case class Symbol(symbol: String, price: Double, size: Int, time: Long)

object jsonParser {
    def parse(input: String) : Option[List[Symbol]] = {
        implicit val symbolDecoder = deriveDecoder[Symbol]
        val decodeResult = parser.decode[List[Symbol]](input.stripMargin)

        decodeResult match { 
            case Right(symbols) => Some(symbols)
            case Left(error) => None
        }
    }
}