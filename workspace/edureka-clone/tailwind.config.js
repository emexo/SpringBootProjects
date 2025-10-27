/** @type {import('tailwindcss').Config} */
export default {
  content: [
    './index.html',
    './src/**/*.{ts,tsx}'
  ],
  theme: {
    extend: {
      colors: {
        brand: {
          DEFAULT: '#0C63E7',
          dark: '#0A4AB8',
          light: '#4C8DFF'
        }
      }
    }
  },
  plugins: []
}