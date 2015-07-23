/**
 * @FILENAME Customer.java
 * 
 * @PURPOSE  A class container for Customer object constructor methods,
 *           setters, and getters.
 *           Provides objects to store all user data as values.
 *
 * @author Justin Goldsmith
 */
package goldsmithfinal;

    public class Customer {

        private String name;
        private int id;
        private int age;
        private char plan;
        private boolean smoker;
        private boolean disability;
        private boolean ltcare;
        private double estimate;

        public Customer(){
            this.name = "Unnamed Customer";
            this.id = 0;
            this.age = 0;
            this.plan = 'U';
            this.smoker = false;
            this.disability = false;
            this.ltcare = false;
            this.estimate = 0.0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId(){
            return this.id;
        }

        public void setId(int id){
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {

            this.age = age;
        }
        
        public void setPlan(char plan){
            this.plan = plan;
        }
        
        public char getPlan(){
            return this.plan;
        }

        public boolean isSmoker() {
            return smoker;
        }

        public void setSmoker(boolean smoker) {
            this.smoker = smoker;
        }

        public boolean isDisability() {
            return disability;
        }

        public void setDisability(boolean disability) {
            this.disability = disability;
        }

        public boolean isLtcare() {
            return ltcare;
        }

        public void setLtcare(boolean ltcare) {
            this.ltcare = ltcare;
        }
        
        public double getEstimate(){
            return this.estimate;
        }
        
        public void setEstimate(double estimate){
            this.estimate = estimate;
        }
        
    }
