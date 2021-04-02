pipeline {
  agent any
  stages {
    stage('Build') {
      steps {  
        sh "gradle compileJava build --refresh-dependencies"   
      }
    }
    stage('Build Docker Image') {
      steps {
          sh '''
				docker build -f Dockerfile -t java-11-demo
				echo "image build completed"
			 '''
      }
    }
  }
}