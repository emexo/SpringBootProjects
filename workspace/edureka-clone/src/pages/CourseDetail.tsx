import { useMemo } from 'react'
import { useParams, Link, Navigate } from 'react-router-dom'
import { courses } from '../data/courses'

export default function CourseDetail() {
	const { courseId } = useParams()
	const course = useMemo(() => courses.find(c => c.id === courseId), [courseId])
	if (!course) return <Navigate to="/courses" replace />

	return (
		<section className="container-responsive py-10">
			<nav className="text-sm text-slate-600 mb-4">
				<Link to="/courses" className="hover:text-brand">Courses</Link> / <span className="text-slate-800">{course.title}</span>
			</nav>
			<div className="grid lg:grid-cols-3 gap-8">
				<div className="lg:col-span-2">
					<img src={course.thumbnailUrl} className="w-full h-64 object-cover rounded" />
					<h1 className="text-3xl font-bold mt-4 mb-2">{course.title}</h1>
					<div className="text-slate-600 mb-4">{course.category} • {course.level} • {course.durationHours}h</div>
					<p className="text-slate-700 mb-6">{course.description}</p>
					<h3 className="font-semibold mb-2">Syllabus</h3>
					<ol className="list-decimal pl-6 space-y-1 text-slate-700">
						{course.syllabus.map((topic, i) => <li key={i}>{topic}</li>)}
					</ol>
				</div>
				<aside>
					<div className="border rounded-lg p-4 sticky top-4">
						<div className="text-3xl font-bold">${course.price}</div>
						<button className="mt-4 w-full px-4 py-2 rounded bg-brand text-white">Enroll now</button>
						<div className="text-sm text-slate-600 mt-2">30-day money-back guarantee</div>
					</div>
				</aside>
			</div>
		</section>
	)
}