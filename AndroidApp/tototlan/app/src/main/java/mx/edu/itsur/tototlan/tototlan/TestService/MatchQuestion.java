/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.TestService;

import java.util.List;

/**
 *
 * @author tobefranco
 */
public class MatchQuestion extends ServiceQuestion{
    private Options answer;
    private List<Match> correct;

    public Options getAnswer() {
        return answer;
    }

    public void setAnswer(Options answer) {
        this.answer = answer;
    }

    public List<Match> getCorrect() {
        return correct;
    }

    public void setCorrect(List<Match> correct) {
        this.correct = correct;
    }
    
    public class Options {
        private List<String> leftOptions;
        private List<String> rightOptions;

        public List<String> getLeftOptions() {
            return leftOptions;
        }

        public void setLeftOptions(List<String> leftOptions) {
            this.leftOptions = leftOptions;
        }

        public List<String> getRightOptions() {
            return rightOptions;
        }

        public void setRightOptions(List<String> rightOptions) {
            this.rightOptions = rightOptions;
        }
    }
    
    public class Match {
        private int left;
        private int right;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
}
