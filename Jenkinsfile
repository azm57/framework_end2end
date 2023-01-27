pipeline {
  agent any
  stages {
    stage("build")  {
      steps{
        echo 'building application...'
        sh 'mvn compile'
      }
    }
    stage("test")  {
      steps{
        echo 'testing application...'
        sh 'mvn ctest'
      }
     }
     stage("deploy")  {
      steps{
        echo 'deploying application...'
        sh 'mvn clean install'
      }
     }
  }
}
