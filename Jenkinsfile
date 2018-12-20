pipeline {
      agent any
      tools {
          maven 'Maven 3.5.2'
          jdk 'jdk1.8.0_151'
       }
      stages {
          stage('Build') {
              steps {
                bat 'mvn install'
              }
                
          }
         stage('Test') {
            steps {
                bat 'mvn test'
            }
        stage('perf') {
  steps { 
   bat 'mvn gatling:test site'
    
      gatlingArchive()
    }
}     
            
        }
   
       
      }
} 
