package com.course.breakingnews.platform

expect class Platform() {
    val osName: String
    val osVersion: String
    val deviceModel: String
}