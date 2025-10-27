import { Link, NavLink } from 'react-router-dom'

export default function Navbar() {
	return (
		<header className="border-b">
			<div className="container-responsive flex items-center justify-between h-16">
				<Link to="/" className="text-2xl font-bold text-brand">Edureka</Link>
				<nav className="hidden md:flex gap-6 text-sm">
					<NavLink to="/courses" className={({isActive}) => isActive ? 'text-brand font-medium' : 'hover:text-brand'}>Courses</NavLink>
					<NavLink to="/about" className={({isActive}) => isActive ? 'text-brand font-medium' : 'hover:text-brand'}>About</NavLink>
					<NavLink to="/contact" className={({isActive}) => isActive ? 'text-brand font-medium' : 'hover:text-brand'}>Contact</NavLink>
				</nav>
				<div className="flex gap-3">
					<button className="px-4 py-2 rounded border">Log in</button>
					<button className="px-4 py-2 rounded bg-brand text-white">Sign up</button>
				</div>
			</div>
		</header>
	)
}