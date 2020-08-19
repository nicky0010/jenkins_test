pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
                deleteDir()
                echo 'hello world'
            }
        }
    }
}
