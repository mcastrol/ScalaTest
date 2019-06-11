import scala.util.Random
import scala.util.matching.Regex
//val salaries = Seq(20000, 70000, 40000)
//val doubleSalary = (x: Int) => x * 2
//
//// #function
//val SalaryCondition = (x: Int) =>
//  if( x < 5000 ){
//    x*2
//  } else {
//    x/2
//  }
//
//// #list example
//val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
//println(newSalaries)
//
//// #applying function
//val newSalaries2 = salaries.map(SalaryCondition) // List(40000, 140000, 80000)
//println(newSalaries2)
//
//val x: Int = Random.nextInt(10000)
//println(x)
//println(SalaryCondition(x))


// #case classes of shoesizeme







//case class ShoeSize(size_numeric: String, scale: String, retailed_size_numeric: String, retailed_scale:String)
case class ShoeSize(size_numeric: String, scale: String, retailed_size_numeric: String, retailed_scale: String,
                    gtin: String, sku: String, shoe_length: String, shoe_height: String, heel_height: String,
                    platform_height: String, stock_level: String)
case class Shoe(
                 title: String,
                 description: String,
                 shoe_category: String,
                 color: String,
                 internal_material:String,
                 material: String,
                 barcode: String
               ) {

}

//val RuleToTest1 = (shoe: Shoe) => {
////  case class ShoeSize(size_numeric: String, scale: String, retailed_size_numeric: String, retailed_scale:String)
//  val sizeStringPattern = """<name>Numara<\/name>\s?<values>\s?((<string>([^<]+)<\/string>)+)\s?<\/values>""".r
//  val internal_material = shoe.internal_material.replaceAll(""">(\s[^<]+)<""", "><")
//  val sizeMatches = sizeStringPattern.findFirstMatchIn(internal_material)
//  var sizesString = ""
//  sizeMatches match {
//    case Some(s) => {
//      sizesString = s.group(1)
//    }
//    case None => {
//      sizesString = ""
//    }
//  }
//  val sizesPattern = """<string>([^<]+)<\/string>""".r
//  var listShoes : List[ShoeSize]= Nil
//  var halfstring : String = "";
//  for (s <- sizesPattern findAllIn  sizesString) {
//    val Decimal = """(\d+)(\.\d*)?""".r
//    for (s2 <- Decimal findFirstIn s) {
//      val shoeSize = ShoeSize(s2+halfstring,"eu","","","","","","","","","")
//      listShoes=shoeSize::listShoes
//    }
//  }
//  //Some(shoe.copy(sizes = listShoes.toSeq))
//}


val RuleToTest2 =
  (shoe: Shoe) => {

    val colourRegex = """(Black|Brown|Blue|Navy\sBlue|Navy|Chocolate|Tan|Royal\sBlue|Oxblood|Mahogany|Burgundy|Oak|Lilac|Teal|Grey|Green|Red|Pink|Yellow|British\sRacing\sGreen|Tangerine)""".r
    val materialRegex = """(Full Grain Leather|Leather|Velvet)""".r

    val colourMatch = colourRegex.findFirstMatchIn(shoe.title);
    var colour = ""
    colourMatch match {
      case Some(s) => {
        colour = s.group(1)
      }
      case None => {
        colour = ""
      }
    }


// Transformation function for size_range_of
    //    ----- (str: String) => {val pattern = """\d+(?:\.\d+)?""".r; pattern.findFirstIn(str).getOrElse(null)}

    val materialMatch = materialRegex.findFirstMatchIn(shoe.title);
    var material = ""
    materialMatch match {
      case Some(s) => {
        material = s.group(1)
      }
      case None => {
        material = ""
      }
    }
}


//    var title = shoe.title.replace(colour, "").replace("-", "").replace(material, "").trim
////    shoe.copy(title = title)
////    shoe.copy(color = "aaaaa")
////    shoe.copy(material = material)
////    Some(shoe)
//    Some(shoe.copy(title = title,color = colour,material=material))
//}


val RuleToTestfake =
  (shoe: Shoe) => {
    Some(shoe.copy(title = "aaaaa"))
  }

val RuleToTest3 =
   (shoe: Shoe) => {

     val categoryRegex = """Complimentary""".r

     val categoryMatch = categoryRegex.findFirstMatchIn(shoe.shoe_category);

     categoryMatch match {
       case Some(s) => {
         None
       }
       case None => {
         Some(shoe)
       }
     }
   }


val RuleToTest3 =
( str: String) =>
   {
    val pattern = """\d+(?:\.\d+)?""".r; pattern.findFirstIn(str).getOrElse(str)

  }

val RuleToTest4 =
  (shoe: Shoe) => {

    val age_groupRegex = """Kids""".r

    val age_groupMatch = age_groupRegex.findFirstMatchIn(shoe.barcode);

    shoe.copy(barcode= "")

    age_groupMatch match {
      case Some(s) => {
        None
      }
      case None => {
        Some(shoe)
      }
    }
  }
////outfitter
//(shoe: Shoe) => {
//  val newSizes = shoe.sizes.filter(
//    size => ! (size.size_numeric.toDouble <= 34.0) || (size.size_numeric.toDouble > 54.0) )
//  )
//  if(newSizes.isEmpty) {
//    None
//  }
//  else {
//    Some(shoe.copy(sizes = newSizes))
//  }
//}

//val ss1 = ShoeSize("32","EU","","","","","","","","","")
//val ss2 = ShoeSize("40","EU","","","","","","","","","")
//val sizes = List(ss1,ss2)
//val sizes1 = List(ShoeSize("","","","","","","","","","",""))
//val sizesSeq = Seq(ss1,ss2)
//
//val shoe1 = Shoe("Longo Komfort","zapatilla adidas","", "<spec> <name>Stil</name><values> <string>Spor terlik</string></values></spec><spec> <name>Renk</name><values> <string>Somon</string><string>Mint</string><string>Ekru</string><string>Pembe</string></values></spec><spec> <name>Numara</name><values> <string>39 - 40</string><string>35 - 36</string><string>37 - 38</string></values></spec><spec> <name>Durum</name><values> <string>Yeni, Kutusunda</string></values></spec><spec> <name>Marka</name><values> <string>A' La</string></values></spec>",sizes1)
//println(shoe1)

val shoe1 = Shoe("The Bedingfeld - Black Leather","","Complimentary D&D Dust Bag One Size", "","","","Adult")


val newShoe1=RuleToTest3(shoe1)
println(newShoe1)

//val newShoe2=RuleToTest3(shoe1)
//println(newShoe2)

//newShoe1 match {

//  case Some(s) => {
//    print(s.sizes)
//  }
//}

//println(newShoe1.getClass)
//
//val shoe2 = Shoe("Skechers","zapatilla adidas","", "    <specs>\n        <spec>\n            <name>Desen</name>\n            <values>\n                <string>Desensiz</string>\n            </values>\n        </spec>\n        <spec>\n            <name>Menşei</name>\n            <values>\n                <string>Diğer</string>\n            </values>\n        </spec>\n        <spec>\n            <name>Renk</name>\n            <values>\n                <string>Kahverengi Koyu</string>\n            </values>\n        </spec>\n        <spec>\n            <name>Numara</name>\n            <values>\n                <string>45.5</string>\n                <string>44</string>\n                <string>46</string>\n                <string>42.5</string>\n                <string>43.5</string>\n                <string>42</string>\n                <string>44.5</string>\n            </values>\n        </spec>\n        <spec>\n            <name>Malzeme</name>\n            <values>\n                <string>Gore-Tex</string>\n            </values>\n        </spec>",sizes1)
//println(shoe2)
//val newShoe2=RuleToTest1(shoe2)
//println(newShoe2)
//newShoe2 match {
//  case Some(s) => {
//    print(s.sizes)
//  }
//}
//println(newShoe2)
//
//
//val shoe3 = Shoe("Longo Komfort","zapatilla adidas","","<spec> <name>Stil</name><values> <string>Spor terlik</string></values></spec><spec> <name>Renk</name><values> <string>Somon</string><string>Mint</string><string>Ekru</string><string>Pembe</string></values></spec><spec> <name>Numara</name><values> <string>39 - 40</string><string>35 - 36</string><string>37 - 38</string></values></spec><spec> <name>Durum</name><values> <string>Yeni, Kutusunda</string></values></spec><spec> <name>Marka</name><values> <string>A' La</string></values></spec>",sizes1)
//println(shoe3)
//val newShoe3=RuleToTest1(shoe1)
//newShoe3 match {
//  case Some(s) => {
//    print(s.sizes)
//  }
//}
//println(newShoe3)
//

//
//val sizeStringPattern = """<name>Numara<\/name>\s?<values>\s?((<string>([^<]+)<\/string>)+)\s?<\/values>""".r
//val sizeMatches = sizeStringPattern.findFirstMatchIn(shoe1.internal_material)
//var sizesString = ""
//sizeMatches match {
//  case Some(s) => {
//    sizesString = s.group(1)
//  }
//  case None => {
//    sizesString = ""
//  }
//}
//val sizesPattern = """<string>([^<]+)<\/string>""".r
//val sizesMatches = sizesPattern.findAllIn(sizesString).group(1)
//var lista : List[ShoeSize]= Nil
//
//for (s <- sizesPattern findAllIn sizesString) {
////  println(s)
//  val Decimal = """(-)?(\d+)(\.\d*)?""".r
//  for (s2 <- Decimal findAllIn s) {
//    val shoeSize = ShoeSize(s2,"eu","","")
//    lista=shoeSize::lista
//    }
//  println(lista)
//}
//shoe1.copy(sizes = lista.toSeq)
//println(shoe1)

//while (sizesMatches.hasNext) {
//  val d = sizesMatches.group(1)
//  println(s"$d")
//}
//sizeMatches match {
//  case Some(s) => {
//    sizesString = s.toString()
//  }
//  case None => {
//    sizesString = ""
//  }
//}
//println(sizesString)



//val sizesSeq: List[ShoeSize] = Nil
//
//while (sizesMatches.hasNext) {
//  val d = sizesMatches.next
//  val ss1 = ShoeSize(d.toString(),"eu","","")
//  sizesSeq = sizesSeq: +ss1
//  println(ss1)
//  //if (sizeMatches.group(1).toInt < 32) println(s"$d: An oldie but goodie.")
//}
//println(sizesSeq)
// val colors = colorsMatches.map(colorMatch => colorMatch.group(1)) mkString ", "
//val sizesArray = sizesMatches.map(sizesMatch => sizesMatch.group(1))

//print(sizesArray)
//   sizesMatches.foreach { m =>
//   println("CC=" + m.group(1) + "AC=" + m.group(2) + "Number=" + m.group(3))

