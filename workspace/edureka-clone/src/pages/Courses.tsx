import { useMemo, useState } from 'react'
import { Link, useLocation } from 'react-router-dom'
import { courses, categories } from '../data/courses'

function useQuery() {
	const { search } = useLocation()
	return useMemo(() => new URLSearchParams(search), [search])
}

export default function Courses() {
	const query = useQuery()
	const [searchText, setSearchText] = useState(query.get('q') ?? '')
	const [category, setCategory] = useState(query.get('category') ?? 'All')

	const filtered = useMemo(() => {
		const text = searchText.toLowerCase()
		return courses.filter(c => {
			const matchText = !text || c.title.toLowerCase().includes(text) || c.description.toLowerCase().includes(text)
			const matchCat = category === 'All' || c.category === category
			return matchText && matchCat
		})
	}, [searchText, category])

	return (
		<section className="container-responsive py-10">
			<h2 className="text-2xl font-semibold mb-6">Courses</h2>
			<div className="flex flex-col md:flex-row gap-3 md:items-center mb-6">
				<input value={searchText} onChange={e => setSearchText(e.target.value)} placeholder="Search courses" className="border rounded px-4 py-2 w-full md:w-96" />
				<select value={category} onChange={e => setCategory(e.target.value)} className="border rounded px-3 py-2 w-full md:w-60">
					<option>All</option>
					{categories.map(c => <option key={c}>{c}</option>)}
				</select>
			</div>
			<div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-6">
				{filtered.map(course => (
					<Link to={`/courses/${course.id}`} key={course.id} className="border rounded-lg overflow-hidden hover:shadow-sm transition-shadow">
						<img src={course.thumbnailUrl} className="h-40 w-full object-cover" />
						<div className="p-4">
							<h3 className="font-semibold mb-1">{course.title}</h3>
							<p className="text-sm text-slate-600 line-clamp-2 mb-3">{course.description}</p>
							<div className="flex items-center justify-between text-sm">
								<span className="text-slate-600">{course.level}</span>
								<span className="font-semibold">${course.price}</span>
							</div>
						</div>
					</Link>
				))}
			</div>
		</section>
	)
}