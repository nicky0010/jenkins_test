properties([
	parameters([
		string(name: 'frEdfBranch', defaultValue: 'support/v1.0', description: 'github target branch'),
		string(name: 'frEdfUtilsBranch', defaultValue: 'support/v1.0', description: 'github target branch'),
	])
])

pipeline {
	agent any
	stages {
		stage('Publish') {
			steps {
				script {
					echo "${workspace}"
					echo "${pwd()}"
					commonProperties = readYaml file: "jenkinsfiles/nicky-artifact/envs/common.yml"
					props = commonProperties.props
					mavenSetting = "${props.mavenSettingXmlPath}"
					function = load "jenkinsfiles/nicky-artifact/functions/function-artifact-promote-release.groovy"
				}
			}
		}
	}
}
