pipeline {

    agent any

    environment {
        fileName = "output.txt"
    }

    stages {
        stage('write file') {
            steps {
                writeFile(file: fileName, text: "BBB")
            }
        }
    }

    post {
        success {
            cleanWs()
        }
    }
}
