//https://docs.scala-lang.org/tour/basics.html
//https://scalafiddle.io/

import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._


object HolaMundo {
  def main(args: Array[String]) {
    println("¡Hola, mundo!")
    val ahora = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format ahora)
    println(df.format(ahora))
  }
}

object Temporizador {
  //  def unaVezPorSegundo(callback: () => Unit) {
  //    while (true) { callback(); Thread sleep 1000 }
  //  }
  //  def tiempoVuela() {
  //    println("El tiempo vuela como una flecha...")
  //  }
  //  def main(args: Array[String]) {
  //    unaVezPorSegundo(tiempoVuela)
  //  }
  //implemented as anonymous function
  // La presencia de una función anónima en este ejemplo es revelada por la flecha a la derecha => que separa los argumentos de la función del cuerpo de esta

  def unaVezPorSegundo(callback: () => Unit) {
    while (true) { callback(); Thread sleep 1000 }
  }
  def main(args: Array[String]) {
    unaVezPorSegundo(
      () => println("El tiempo vuela como una flecha como función anonima ...")
    )
  }
}


//#SELECT SHOES
(shoe: Shoe) => {
  val pattern = """<code>(eg|ega|egb|egc|egd|ege|eh|eha|ehb|ehc|ehd|ehe|ehf|ehg|ebcb|ebeb|ebub|jbe|jea|jfc|jib|jja|joa|joaa|joab|joac|joad|joae|jgh|egf|ehh|jpd|jzhb|jlbd|eum|elab|elbb|elcb|ejga|3me|jkaad|cpx|ehi|euma|eumb|eumc|eumd|eume|epk|epka|epkb|epkc|ehj|jkbb|jzj|ehk|ehl|egh|eumf|jlga|rdx|rdxa|rdxb|rdxc|)<\/code>""".r
  var category = shoe.shoe_category

  val match1 = pattern.findFirstIn(category)
  match1 match {
    case Some(s) => {
      Some(shoe)
    }
    case None => {
      None
    }
  }
}

//#SELECT GENDER
(shoe: Shoe) => {
  val pattern = """(Kadın|Erkek)""".r
  var category = shoe.shoe_category

  val match1 = pattern.findFirstIn(category)
  var gender = "unisex"
  match1 match {
    case Some(s) => {
      if(s.equals("Kadın")) {
        gender = "women"
      } else {
        gender = "men"
      }
    }
    case None => {
      gender = "unisex"
    }
  }
  Some(shoe.copy(gender=gender))

}

//set color
(shoe: Shoe) => {
  val pattern = """<name>Renk<\/name>\s?<values>\s?<string>([^<]+)<\/string>""".r
  var color_full = shoe.color
  val color = for (m <- pattern.findFirstMatchIn(color_full)) yield m.group(1)
  Some(shoe.copy(color = color.getOrElse("")))
}