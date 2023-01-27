pipeline {
  agent any
  stages {
    stage("build")  {
      steps{
        echo 'building application...'
        bat 'mvn compile'
      }
    }
    stage("test")  {
      steps{
        echo 'testing application...'
        bat 'mvn test'
      }
     }
     stage("deploy")  {
      steps{
        echo 'deploying application...'
        bat 'mvn clean install'
      }
     }
  }
}
