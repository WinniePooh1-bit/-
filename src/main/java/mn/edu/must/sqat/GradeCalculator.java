package mn.edu.must.sqat;

public class GradeCalculator {

    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Оноо 0-ээс 100-ийн хооронд байх ёстой.");
        }
        if (score > 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    public double totalScore(double att, double lab, double quiz1, double quiz2, double exam) {
        if (att < 0 || att > 10) throw new IllegalArgumentException("Ирц 0-10 хооронд байна.");
        if (lab < 0 || lab > 40) throw new IllegalArgumentException("Лаборатори 0-40 хооронд байна.");
        if (quiz1 < 0 || quiz1 > 10) throw new IllegalArgumentException("Сорил 1 0-10 хооронд байна.");
        if (quiz2 < 0 || quiz2 > 10) throw new IllegalArgumentException("Сорил 2 0-10 хооронд байна.");
        if (exam < 0 || exam > 30) throw new IllegalArgumentException("Шалгалт 0-30 хооронд байна.");

        return att + lab + quiz1 + quiz2 + exam;
    }
}
