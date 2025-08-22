import { Routes, Route, Navigate } from 'react-router-dom'
import RootLayout from './layouts/RootLayout'
import Home from './pages/Home'
import Courses from './pages/Courses'
import CourseDetail from './pages/CourseDetail'
import About from './pages/About'
import Contact from './pages/Contact'

export default function App() {
	return (
		<Routes>
			<Route element={<RootLayout />}>
				<Route index element={<Home />} />
				<Route path="courses" element={<Courses />} />
				<Route path="courses/:courseId" element={<CourseDetail />} />
				<Route path="about" element={<About />} />
				<Route path="contact" element={<Contact />} />
			</Route>
			<Route path="*" element={<Navigate to="/" replace />} />
		</Routes>
	)
}
