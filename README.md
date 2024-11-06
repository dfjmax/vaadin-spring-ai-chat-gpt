# PathBuddy Chat: Plan Your Next Adventure

## Project Overview
A Vaadin-based web app that simulates a ChatGPT-like chat interface, built with Spring Boot, Kotlin, and Spring AI. 

This project demonstrates how to integrate AI-driven chat using the Spring AI Ollama library with a customizable memory advisor, 
perfect for applications like virtual trip planning.

## Key Features
1. **AI Chat Interface**: Chat with the AI assistant, “Path Buddy,” who offers travel advice and suggestions.
2. **Memory-Driven Responses**: Contextual, memory-enabled conversations that retain prior interactions.
3. **User-Friendly UI**: Designed with Vaadin for a sleek, responsive chat experience.
4. **Kotlin & Reactive Programming**: Leverages Kotlin and Reactor for non-blocking, reactive chat responses.

## Tech Stack
- **Kotlin**
- **Spring Boot 3.3.4 (Spring AI)**
- **Ollama AI**
- **LLaMA models**
- **Vaadin**


### Prerequisites
- **Java 21** or higher.
- **Ollama** installed locally (instructions below)
- **Maven**

### Setting up Ollama

To install Ollama, follow these steps:

1. **Download Ollama**: Visit the [Ollama download page](https://ollama.com/download) and download the installer for your operating system.
2. **Install the application**: Follow the instructions on the page to install Ollama on your system.
3. **Download the Mistral Model**: Go to the terminal and run: `ollama pull mistral`

Once Ollama is installed, you can use the model directly with the Spring Boot application.

## Project Structure

### Main Components
1. **ChatService**: Handles communication with the AI model using ChatClient.
2. **ChatConfig**: Configures the chat memory and advisors for personalized conversation context.
3. **ChatView:** Manages chat UI with Vaadin, including message display and user input.
4. **MainLayout**: Provides a navigation bar with the app title.

## How to Run the Application

### Steps to Run

1. **Clone the Repository**
    ```bash
    git clone https://github.com/dfjmax/vaadin-spring-ai-chat-gpt.git
    cd vaadin-spring-ai-chat-gpt
    ```
2. **Starting the application**: After the model is downloaded simply run:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```