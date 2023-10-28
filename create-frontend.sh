#!/bin/bash

pname=$1

if [ -z "$pname" ]; then
    echo "Provide a name for you project"
    exit 1
fi

# Vite init + ts
npm init vite@latest "$pname" -- --template react-ts
cd "$pname"

# Tailwindcss init
npm install
npm install tailwindcss postcss autoprefixer
npx tailwindcss init -p

# Config files correction
rm -rf tailwind.config.js
echo '/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}"
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}' > tailwind.config.js

rm -rf src/index.css
echo '@import "tailwindcss/base";
@import "tailwindcss/components";
@import "tailwindcss/utilities";' > src/index.css

rm -rf vite.config.js
echo 'import { defineConfig } from "vite"
import react from "@vitejs/plugin-react"
import tailwindcss from "tailwindcss"


export default defineConfig({
  plugins: [
    react(),
    tailwindcss(),
  ]
})' > vite.config.js

# Delete boilerplate
cd src
rm -rf App.css

# Create architecture
mkdir customhooks
mkdir components
mkdir pages
mkdir services
mkdir utils
mkdir lib
mkdir styles

# Edit README
cd ..
rm -rf README.md
echo '# Vite + Typescript + Tailwindcss project' > README.md

# Edit App.js
cd src
rm -rf App.jsx
echo '

export const App = () => {
    return(
        <div className="flex bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-400 justify-center items-center h-screen w-full">
            <h1 className="font-serif text-8xl font bold text-center text-white hover:-translate-y-10 transition-all duration-500">Hello Bitches!</h1>
        </div>
    )
}

export default App;' > App.tsx

# Making a gitCommands.sh for shortcuts
cd ..
echo '#!/bin/bash

commitmsg=$1
buildandhost=$2

if [ -z "$commitmsg" ]; then
	echo "Provide a commit message."
	exit 1
elif [ "$buildandhost" == "prod" ]; then
	npm run build
	firebase deploy --only hosting
	git pull
	git add .
	git commit -m "$commitmsg"
	git push
elif [ "$commitmsg" == "ur" ]; then
	git pull
	git add .
	git commit -m "Updated README"
	git push
elif [ "$commitmsg" == "cc" ]; then
	git pull
	git add .
	git commit -m "Cleaned up some code"
	git push
elif [ "$commitmsg" == "bug" ]; then
	git pull
	git add .
	git commit -m "Fixed some bugs"
	git push
elif [ "$commitmsg" == "doc" ]; then
	git pull
	git add .
	git commit -m "Added and cleaned up some documentation"
	git push
elif [ "$commitmsg" == "help" ]; then
	echo ""
	echo ""
	echo "ALL COMMANDS"
	echo "  prod  runs build and hosting after push"
	echo "  ur    Update README"		
	echo "  cc    Clean up some code"
	echo "  bug   Fixed some bugs"
	echo "  doc   Added some documentation"
	echo ""
	echo ""
else
	git pull
	git add .
	git commit -m "$commitmsg"
	git push
fi
' > gitCommands.sh

# Start development server
npm run dev