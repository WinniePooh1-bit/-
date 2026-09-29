# Лаборатори №4: Нэгжийн тест JUnit 5

## Тестийн Мэдээлэл

* **Кодон доторх тестийн МЕТОД-ын тоо:** 8 метод (`test1_...`-ээс `test8_...`)
* **`results/mvn-test.txt` дээрх сургалтын тоо ("Tests run: N"):** Tests run: 17, Failures: 0, Errors: 0, Skipped: 0

> **Санамж:** JUnit 5-ийн Surefire плагин нь `@ParameterizedTest` тус бүрийн `@CsvSource` мөр бүрийг бие даасан тест гэж тоолдог. Кодон дотор яг 8 тестийн метод бичигдсэн бөгөөд CsvSource датанууд нэмэгдсэнээр нийт "Tests run: 17" болж гарсан.

---

## Мутацийн тестийн үр дүн

`GradeCalculator.java` доторх `score >= 90` нөхцөлийг зориуд `score > 90` болгон өөрчилж `results/mvn-test-mutant.txt` файл руу гараасыг хадгалахад:
* `test1_letterGradeBoundaryExactly90IsA()` тест унасан.
* `test4_letterGradeBoundariesParameterized` доторх `90.0 -> A` мөр унасан.
* Гаралт дээр **BUILD FAILURE** (Failures: 2) заасан.

Энэ нь манай тестүүд 90 гэсэн хязгаарын утгыг чанартай шалгаж байгааг баталж байна.

---

## Дүгнэлт

Энэхүү лабораторийн ажлаар JUnit 5 ашиглан нэгжийн тест бичиж, Maven Surefire плагинаар тестийг автоматаар ажиллууллаа. `GradeCalculator` классын `letterGrade` болон `totalScore` функцүүдийн сөрөг ба дээд хязгаар хэтэрсэн оролтуудыг `assertThrows` болон `IllegalArgumentException` ашиглан амжилттай шалгасан. Мутацийн тест ажиллуулж хязгаарын нөхцөл шалгах тестийн чанарыг баталгаажуулсан.
