import java.util.Scanner;

class Question {
    String questionText;
    String[] choices;
    int correctAnswerIndex;

    Question(String questionText, String[] choices, int correctAnswerIndex) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswerIndex;
    }

    void display() {
        System.out.println(questionText);
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question[] questions = {
            new Question(
                "who is the father of java?",
                new String[]{"Guido van Rossum", "James Gosling", "Dennis Ritchie", "Charles Babbage"},
                1
            ),
            new Question(
                "Which country is Cristiano Ronaldo from?",
                new String[]{"Brazil", "Argentina", "Portugal", "Spain"},
                2
            ),
            new Question(
                "Which number does Ronaldo famously wear?",
                new String[]{"7", "9", "10", "11"},
                0
            )
        };

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1));
            questions[i].display();
            System.out.print("Your answer (1-" + questions[i].choices.length + "): ");
            int answer = scanner.nextInt() - 1;

            if (questions[i].isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " +
                    questions[i].choices[questions[i].correctAnswerIndex]);
            }
        }

        System.out.println("\nQuiz Over! You scored " + score + " out of " + questions.length);
        scanner.close();
    }
}


// guhan