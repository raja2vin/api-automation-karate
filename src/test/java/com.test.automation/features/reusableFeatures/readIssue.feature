@ignore
# This is a reusuable feature of gitLab read issue operation
Feature: I want to generate reusuable read issue operation in Gitlab

    #This scenario will be used read the issues in gitlab
    #Mandatory Input: issue id (iid)
    #Authentication: Oauth or Private-Token
    #This scenario get the issues and return the response back
    Scenario: read issues
        * def issueId = readIssueId
        Given url baseUrl + 'api/v4/projects/'+projectId+'/issues/' + readIssueId
        When method GET