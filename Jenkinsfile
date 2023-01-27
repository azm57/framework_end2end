pipeline {
  agent any
  stages {
    stage("build")  {
      steps{
        echo 'building application...'
        mvn compile
      }
    }
    stage("test")  {
      steps{
        echo 'testing application...'
        mvn test
      }
     }
     stage("deploy")  {
      steps{
        echo 'deploying application...'
        mvn install
      }
     }
  }
}
