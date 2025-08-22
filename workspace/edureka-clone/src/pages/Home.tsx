import { Link } from 'react-router-dom'
import { categories } from '../data/courses'

export default function Home() {
	return (
		<section className="container-responsive py-12">
			<div className="grid md:grid-cols-2 gap-10 items-center">
				<div>
					<h1 className="text-4xl md:text-5xl font-bold mb-4">Upskill with industry-ready courses</h1>
					<p className="text-slate-600 mb-6">Learn top tech skills from curated programs designed with experts. Hands-on projects, certification guidance, and career support.</p>
					<div className="flex gap-3 mb-8">
						<input placeholder="What do you want to learn?" className="border rounded px-4 py-2 w-full md:w-96" />
						<Link to="/courses" className="px-4 py-2 rounded bg-brand text-white">Search</Link>
					</div>
					<div className="flex flex-wrap gap-2">
						{categories.map(cat => (
							<Link key={cat} to={`/courses?category=${encodeURIComponent(cat)}`} className="px-3 py-1 text-sm rounded-full border hover:bg-slate-50">{cat}</Link>
						))}
					</div>
				</div>
				<div className="bg-slate-50 border rounded-xl h-64 md:h-80" />
			</div>
		</section>
	)
}