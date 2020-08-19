pipeline {
    agent any
    stages {
        stage('write file') {
            steps {
                deleteDir()
                writeFile(file: "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/output.txt", text: "${OUTPUT_TEXT}")
                echo "${pwd()}"
            }
        }
    }
}
