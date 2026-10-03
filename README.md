# Лаборатори №4: Нэгжийн тест JUnit 5

* **Оюутны нэр:** М.Наранбат
* **Оюутны код:** B242270801
* **Java хувилбар (`java -version`):** `openjdk version "17.0.20.1" 2026-08-18`
* **Compiler хувилбар (`javac -version`):** `javac 17.0.20.1`
* **Maven хувилбар (`mvn -version`):** `Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)`

---

## Тестийн Мэдээлэл

* **Кодон доторх тестийн МЕТОД-ын тоо:** 8 метод (`test1_...`-ээс `test8_...`)
* **`results/mvn-test.txt` дээрх сургалтын тоо ("Tests run: N"):** Tests run: 17, Failures: 0, Errors: 0, Skipped: 0

> **Санамж:** JUnit 5 Surefire плагин нь `@ParameterizedTest` тус бүрийн `@CsvSource` мөр бүрийг тусдаа тест гэж тоолдог тул 8 метод нь салган тоологдож нийт "Tests run: 17" болж гарсан.

---

## Мутацийн тестийн үр дүн

`GradeCalculator.java` доторх `score >= 90` нөхцөлийг зориуд `score > 90` болгон өөрчилж `results/mvn-test-mutant.txt` файл руу гараасыг хадгалахад:
* `test1_letterGradeBoundaryExactly90IsA()` болон parameterized тестүүд дээр Failure гарсан.
* Гаралт дээр **BUILD FAILURE** (Failures >= 1) заасан.

---

## Дүгнэлт

Энэхүү лабораторийн ажлаар JDK 17 орчинд JUnit 5 болон Maven Surefire плагин ашиглан нэгжийн тестүүдийг амжилттай ажиллууллаа. Мутацийн тестээр 90 гэсэн хязгаарын нөхцөлийн шалгалтын чанарыг бүрэн баталгаажуулсан.
