import scala.util.Random
import scala.util.matching.Regex


class test {
  // Start writing your ScalaFiddle code here
  // Start writing your ScalaFiddle code here



  // #case classes of shoesizeme
  case class ShoeSize(size_numeric: String, scale: String, retailed_size_numeric: String, retailed_scale:
  String)
  case class Shoe(
                   title: String,
                   description: String,
                   color: String,
                   internal_material: String,
                   sizes: Seq[ShoeSize]
                 ) {

  }
  // #funtion rule to test
  val RuleToTest = (shoe: Shoe) => {
    val newSizes = shoe.sizes.filter(
      size => !(size.scale == "us" || (size.size_numeric.toDouble <= 32.0))
    )
    if(newSizes.isEmpty) {
      None
    }
    else {
      Some(shoe.copy(sizes = newSizes))
    }
  }

  // #color
  val RuleToTest2 = (shoe: Shoe) => {
    val colorsStringPattern = """<name>Renk<\/name>\s?<values>\s?((<string>([^<]+)<\/string>)+)\s?<\/values>""".r
    val colorMatches = colorsStringPattern.findFirstMatchIn(shoe.internal_material)
    var colorsString = ""
    colorMatches match {
      case Some(s) => {
        colorsString = s.group(1)
      }
      case None => {
        colorsString = ""
      }
    }
    val colorsPattern = """<string>([^<]+)<\/string>""".r
    val colorsMatches = colorsPattern.findAllMatchIn(colorsString)
    val colors = colorsMatches.map(colorMatch => colorMatch.group(1)) mkString ", "
    Some(shoe.copy(color = colors))

  }


  // #rule to remove the words after Gr and number
  // #Longo Komfort Pantoletten für Damen, beige, Gr. 41

  // (S|s)cala
  val RuleToTest3 =
    (shoe: Shoe) => {
      var title = shoe.title
      title = title.replaceAll("""((G|g)rau|(B|b)eige|(S|s)chwarz|(L|l)ila|(B|b)raun)(,.)?""", "")
      // remove genre
      title = title.replaceAll("""(F|f)ür (D|d)amen|(F|f)ür (H|h)erren(.,)?""", "")
      //remove size
      title = title.replaceAll( """(G|g)r[..]? [0-9]+""", "")
      //remove extra ,
      title = title.replaceAll( """(,)""", "")
      title = title.trim
      Some(shoe.copy(title = title))
    }



  //sample sizes
  val ss1 = ShoeSize("32","EU","","")
  val ss2 = ShoeSize("40","EU","","")
  val sizes = Seq(ss1,ss2)
  println(sizes)

  /* title: description color internal_material  sizes */
  // sample shoe
  val shoe1 = Shoe("Longo Komfort","zapatilla adidas","", "	<spec> <name>Stil</name><values> <string>Spor terlik</string></values></spec><spec> <name>Renk</name><values> <string>Somon</string><string>Mint</string><string>Ekru</string><string>Pembe</string></values></spec><spec> <name>Numara</name><values> <string>39 - 40</string><string>35 - 36</string><string>37 - 38</string></values></spec><spec> <name>Durum</name><values> <string>Yeni, Kutusunda</string></values></spec><spec> <name>Marka</name><values> <string>A' La</string></values></spec>",sizes)
  println(shoe1)
  val newShoe1=RuleToTest2(shoe1)
  println(newShoe1)

  val shoe2 = Shoe("Skechers","zapatilla adidas","", "<spec> <name>Stil</name><values> <string>Dolgu topuk, Platform</string></values></spec><spec> <name>Desen</name><values> <string>Desensiz</string></values></spec><spec> <name>Renk</name><values> <string>Siyah</string></values></spec><spec> <name>Numara</name><values> <string>35</string><string>36</string><string>37</string><string>38</string><string>39</string><string>40</string></values></spec><spec> <name>Malzeme</name><values> <string>Suni Deri</string></values></spec><spec> <name>Durum</name><values> <string>Yeni, Kutusunda</string></values></spec><spec> <name>Marka</name><values> <string>Sothe</string></values></spec>",sizes)
  println(shoe2)
  val newShoe2=RuleToTest2(shoe2)
  println(newShoe2)


  //testing rule
  // val newShoe1=RuleToTest3(shoe1)
  // println(newShoe1)


  // val pattern = "(.*)(Material)(.*)/gmt".r

  // val pattern: Regex = "[0-9]".r

  // println("regexp")
  // println(pattern.findFirstMatchIn(material).group(1))

  // var reg: Regex = "/#([\S]+)/igm".r; // Get hashtags.

  // var string = "mi alegría es total! ✌fiestasdefindeaño #PadreHijo #buenosmomentos #france #paris"'

  // var matches = (string.match(reg) || []).map(e => e.replace(reg, '$1'));
  // println(matches)


  // for (patternMatch <- pattern.findAllMatchIn(material))
  //   println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")


  // println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")

  //testing rule
  // val newShoe1=RuleToTest2(shoe1)
  // println(newShoe1)

  // val keyValPattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r

  // val input: String =
  //   """background-color: #A03300;
  //     |background-image: url(img/header100.png);
  //     |background-position: top center;
  //     |background-repeat: repeat-x;
  //     |background-size: 2160px 108px;
  //     |margin: 0;
  //     |height: 108px;
  //     |width: 100%;""".stripMargin

  // for (patternMatch <- keyValPattern.findAllMatchIn(input))
  //   println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")

  // #rule to remove the words after Gr and number
  // #Longo Komfort Pantoletten für Damen, beige, Gr. 41

  // (S|s)cala
  val RuleToTest4 =
    (shoe: Shoe) => {
      var title = shoe.title
      title = title.replaceAll("""((G|g)rau|(B|b)eige|(S|s)chwarz|(L|l)ila|(B|b)raun)(,.)?""", "")
      // remove genre
      title = title.replaceAll("""(F|f)ür (D|d)amen|(F|f)ür (H|h)erren(.,)?""", "")
      //remove size
      title = title.replaceAll( """(G|g)r[..]? [0-9]+""", "")
      //remove extra ,
      title = title.replaceAll( """(,)""", "")
      title = title.trim
      Some(shoe.copy(title = title))
    }



  //sample sizes
  val ss1 = ShoeSize("32","EU","","")
  val ss2 = ShoeSize("40","EU","","")
  val sizes = Seq(ss1,ss2)
  println(sizes)

  /* title: description color internal_material  sizes */
  // sample shoe
  val shoe1 = Shoe("Longo Komfort","zapatilla adidas","", "	<spec> <name>Stil</name><values> <string>Spor terlik</string></values></spec><spec> <name>Renk</name><values> <string>Somon</string><string>Mint</string><string>Ekru</string><string>Pembe</string></values></spec><spec> <name>Numara</name><values> <string>39 - 40</string><string>35 - 36</string><string>37 - 38</string></values></spec><spec> <name>Durum</name><values> <string>Yeni, Kutusunda</string></values></spec><spec> <name>Marka</name><values> <string>A' La</string></values></spec>",List[String]())
  println(shoe1)
  val newShoe1=RuleToTest1(shoe1)
  println(newShoe1)

  val shoe2 = Shoe("Skechers","zapatilla adidas","", "<spec> <name>Stil</name><values> <string>Dolgu topuk, Platform</string></values></spec><spec> <name>Desen</name><values> <string>Desensiz</string></values></spec><spec> <name>Renk</name><values> <string>Siyah</string></values></spec><spec> <name>Numara</name><values> <string>35</string><string>36</string><string>37</string><string>38</string><string>39</string><string>40</string></values></spec><spec> <name>Malzeme</name><values> <string>Suni Deri</string></values></spec><spec> <name>Durum</name><values> <string>Yeni, Kutusunda</string></values></spec><spec> <name>Marka</name><values> <string>Sothe</string></values></spec>",List[String]())
  println(shoe2)
  val newShoe2=RuleToTest1(shoe2)
  println(newShoe2)
}
