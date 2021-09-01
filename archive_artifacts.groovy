pipeline {

    agent any

    environment {
        fileName = "output.txt"
    }

    stages {
        stage('delete workspace') {
            steps {
                deleteDir()
            }
        }

        stage('write file') {
            steps {
                writeFile(file: fileName, text: "BBB")
            }
        }
    }

//    post {
//        success {
//            cleanWs()
//        }
//    }
}
