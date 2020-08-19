pipeline {
    agent any
    stages {
        stage('write file') {
            steps {
                writeFile(file: "${pwd()}@tmp/jenkinsfiles/nicky-artifact/envs/output.txt", text: "${OUTPUT_TEXT}")
            }
        }
    }
}
